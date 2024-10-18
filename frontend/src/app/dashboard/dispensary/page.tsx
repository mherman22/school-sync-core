import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Textarea } from '@/components/ui/textarea';

export default function DispensaryPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Dispensary</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">
            Record Health Visit
          </CardTitle>
          <CardDescription className="text-gray-600">
            Enter details of a student&apos;s health visit.
          </CardDescription>
        </CardHeader>
        <CardContent>
          <form className="space-y-4">
            <Input
              className="bg-white text-black border-gray-300"
              placeholder="Student Name"
            />
            <Input
              className="bg-white text-black border-gray-300"
              type="date"
            />
            <Textarea
              className="bg-white text-black border-gray-300"
              placeholder="Symptoms"
              rows={3}
            />
            <Textarea
              className="bg-white text-black border-gray-300"
              placeholder="Treatment"
              rows={3}
            />
            <Button className="bg-blue-600 text-white hover:bg-blue-700">
              Record Visit
            </Button>
          </form>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">
            Recent Health Visits
          </CardTitle>
          <CardDescription className="text-gray-600">
            View recent student health visits.
          </CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">
                John Doe - Headache - 15/05/2023
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
                Jane Smith - Fever - 16/05/2023
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
