import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"

export default function TeachersPage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Teachers</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Add New Teacher</CardTitle>
          <CardDescription className="text-gray-600">Enter details to add a new teacher to the system.</CardDescription>
        </CardHeader>
        <CardContent>
          <form className="space-y-4">
            <Input className="bg-white text-black border-gray-300" placeholder="Full Name" />
            <Input className="bg-white text-black border-gray-300" type="email" placeholder="Email" />
            <Input className="bg-white text-black border-gray-300" placeholder="Subject" />
            <Button className="bg-blue-600 text-white hover:bg-blue-700">Add Teacher</Button>
          </form>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Teacher List</CardTitle>
          <CardDescription className="text-gray-600">View and manage existing teachers.</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">John Doe - Mathematics</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Edit</Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Jane Smith - English</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Edit</Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  )
}
