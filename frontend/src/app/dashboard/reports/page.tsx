import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';

export default function ReportsPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Reports</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">
            Generate Student Reports
          </CardTitle>
          <CardDescription className="text-gray-600">
            Select a class and generate reports for all students.
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="flex space-x-4">
            <Select>
              <SelectTrigger className="w-[180px] bg-white text-black border-gray-300">
                <SelectValue placeholder="Select Class" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="class1">Class 1</SelectItem>
                <SelectItem value="class2">Class 2</SelectItem>
                <SelectItem value="class3">Class 3</SelectItem>
              </SelectContent>
            </Select>
            <Button className="bg-blue-600 text-white hover:bg-blue-700">
              Generate Reports
            </Button>
          </div>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">View Reports</CardTitle>
          <CardDescription className="text-gray-600">
            Access and view previously generated reports.
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">
                Class 1 - Term 1 Reports
              </span>
              <Button
                variant="outline"
                className="text-blue-600 border-blue-600 hover:bg-blue-50"
              >
                View
              </Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">
                Class 2 - Term 2 Reports
              </span>
              <Button
                variant="outline"
                className="text-blue-600 border-blue-600 hover:bg-blue-50"
              >
                View
              </Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">
                Class 3 - Term 3 Reports
              </span>
              <Button
                variant="outline"
                className="text-blue-600 border-blue-600 hover:bg-blue-50"
              >
                View
              </Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
